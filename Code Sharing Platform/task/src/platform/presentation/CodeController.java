package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.business.Code;
import platform.business.CodeNew;
import platform.business.CodeService;
import platform.business.CodeWrapper;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class CodeController {

    @Autowired
    CodeService codeService;

    // GET /code/UUID should contain the following elements:
    //1.<span id="time_restriction"> ... </span> in case the time restriction is applied.
    //2. <span id="views_restriction"> ... </span> in case the views restriction is applied.
    @GetMapping("/code/{uuid}")
    public String getCodeHTML(HttpServletResponse response, @PathVariable String uuid, Model model) {
        response.addHeader("Content-Type", "text/html");

        System.out.println("[DEBUG-F] call: " + uuid);

        String temp = "";

        Code code = codeService.findCodeById(uuid);

        if (code == null) {
            System.out.println(code);

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        } else {
            if (code.isHidden()) {
                if ((LocalDateTime.now().isBefore(code.getDateUnformatted().plusSeconds(code.getTime())) || code.getTime() == 0)
                        && code.getViews() >= 0
                ) {

                    System.out.println("[DEBUG-F] Viewed snippet: " + code.getCode() + "\n" + code.getViews() + ", " + code.getTime());

                    if (code.getViews() == 0 && code.getTime() == 0) {
                        throw new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "entity not found"
                        );
                    }

                    if (code.getViews() >= 0) {
                        code.setViews(code.getViews() - 1);
                    }

                    int duration = (int) Math.abs(Duration.between(code.getDateUnformatted().plusSeconds(code.getTime()), LocalDateTime.now()).toSeconds());
                    codeService.save(code);
                    model.addAttribute("duration", duration);
                    model.addAttribute("code", code);
                } else {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "entity not found"
                    );
                }
            } else {
                code.setViews(-1);
                model.addAttribute("code", code);
            }
        }

        return "code";
    }

    // GET /api/code/UUID should not be accessible if one of the restrictions is triggered. Return 404 Not Found in this case and all the cases when no snippet with such a UUID was found.
    //GET /api/code/UUID should show what restrictions apply to the code piece. Use the keys time and views for that. A zero value (0) should correspond to the absence of the restriction.
    //1. time field contains the time (in seconds) during which the snippet is accessible.
    //2. views field shows how many additional views are allowed for this snippet (excluding the current one).
    @GetMapping("/api/code/{uuid}")
    @ResponseBody
    public CodeWrapper getCode(HttpServletResponse response, @PathVariable String uuid) {
        response.addHeader("Content-Type", "application/json");

        System.out.println("[DEBUG-API] call: " + uuid);

        System.out.println(uuid);
        Code code = codeService.findCodeById(uuid);
        System.out.println(code.getCode());
        System.out.println("Duration:" + (int) Math.abs(Duration.between(code.getDateUnformatted().plusSeconds(code.getTime()), LocalDateTime.now()).toSeconds()));
        System.out.println("Condition" + LocalDateTime.now().isBefore(code.getDateUnformatted().plusSeconds(code.getTime())));
        System.out.println(code.getDateUnformatted().plusSeconds(code.getTime()));

        if (code.isHidden()) {
            if ((LocalDateTime.now().isBefore(code.getDateUnformatted().plusSeconds(code.getTime())) || code.getTime() == 0)
                    && code.getViews() >= 0
            ) {
                if (code.getViews() == 0 && code.getTime() == 0) {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "entity not found"
                    );
                }

                System.out.println("[DEBUG-API] Viewed snippet: " + code.getCode() + "\n" + code.getViews() + ", time: " + code.getTime());

                if (code.getViews() > 0) {
                    code.setViews(code.getViews() - 1);
                }

                System.out.println("[DEBUG-API] Time before calculation: " + code.getTime());

                int duration = 0;

                if (code.getTime() > 0) {
                    duration = (int) Math.abs(Duration.between(code.getDateUnformatted().plusSeconds(code.getTime()), LocalDateTime.now()).toSeconds());
                }

                System.out.println("[DEBUG-API] Time inside: " + duration);

                if (code.getTime() < 0) {
                    code.setTime(0);
                }

                codeService.save(code);
                return new CodeWrapper(code.getCode(), code.getDate(), duration, code.getViews());
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                );
            }

        } else {
            return new CodeWrapper(code.getCode(), code.getDate(), code.getTime(), code.getViews());
        }
    }

    // POST /api/code/new should take a JSON object with a field code and two other fields:
    //1. time field contains the time (in seconds) during which the snippet is accessible.
    //2. views field contains a number of views allowed for this snippet.
    //Remember, that 0 and negative values should correspond to the absence of the restriction.
    @PostMapping("/api/code/new")
    @ResponseBody
    public Map<String, String> addCode(@RequestBody CodeNew code) {

        Code codeObj = new Code(
                code.getCode(),
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                code.getTime(),
                code.getViews(),
                !(code.getTime() == 0 && code.getViews() == 0)
        );

        System.out.println("[DEBUG] Snippet: " + code.getCode() + "\n" + code.getViews() + " " + code.getTime());

        codeService.save(codeObj);
        return Map.of("id", codeObj.getUuid());
    }

    // GET /code/new should contain two elements on top of the others:
    //1. <input id="time_restriction" type="text"/> should contain the time restriction.
    //2. <input id="views_restriction" type="text"/> should contain the views restriction
    @GetMapping("/code/new")
    public String getNewCodeHTML(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return "new";
    }

    // GET /api/code/latest and GET /code/latest should not return any restricted snippets.
    @GetMapping("/api/code/latest")
    @ResponseBody
    public List<CodeWrapper> getLatestCodes(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");

        System.out.println("[DEBUG-API] Showing latest snippets...");

        List<Code> originals = new ArrayList<>(codeService.findAllByOrderByDateDesc());
        List<CodeWrapper> wrappers = new ArrayList<>();

        int temp = 0;

        for (Code item : originals) {
            if (!item.isHidden()) {
                wrappers.add(new CodeWrapper(item.getCode(), item.getDate()));
                temp++;

                if (temp == 10) {
                    break;
                }
            }
        }

        System.out.println("[DEBUG-API] originals size: " + originals.size() + ", wrappers size: " + wrappers.size());

        return wrappers;
    }

    // GET /api/code/latest and GET /code/latest should not return any restricted snippets.
    @GetMapping("/code/latest")
    public String getLatestCode(HttpServletResponse response, Model model) {
        response.addHeader("Content-Type", "text/html");

        System.out.println("[DEBUG-F] Showing latest snippets...");

        List<Code> originals = new ArrayList<>(codeService.findAllByOrderByDateDesc());
        List<CodeWrapper> wrappers = new ArrayList<>();

        int temp = 0;

        for (Code item : originals) {
            if (!item.isHidden()) {
                wrappers.add(new CodeWrapper(item.getCode(), item.getDate()));

                temp++;

                if (temp == 10) {
                    break;
                }
            }
        }

        System.out.println("[DEBUG-API] originals size: " + originals.size() + ", wrappers size: " + wrappers.size());

        model.addAttribute("codes", wrappers);

        return "latest";
    }
}
