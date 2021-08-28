package platform.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.persistence.CodeRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code findCodeById(String uuid) {
        return codeRepository.findCodeByUuid(uuid);
    }

    public Code save(Code toSave) {
        return codeRepository.save(toSave);
    }

    public List<Code> findTop10ByOrderByDateDesc() {
        return codeRepository.findTop10ByOrderByDateDesc();
    }

    public List<Code> findAllByOrderByDateDesc() {
        return codeRepository.findAllByOrderByDateDesc();
    }
}
