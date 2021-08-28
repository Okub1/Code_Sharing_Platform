package platform.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Code {

    @Column
    private String code;

    @Id
    @Column(name = "id")
    private String uuid;

    @Column
    private LocalDateTime date;

    @Column
    private Integer time; // in seconds

    @Column
    private Integer views;

    @Column
    private Boolean hidden = false;

    public Code() {
        this.date = LocalDateTime.now();
    }

    public Code(String code) {
        this.code = code;
        this.date = LocalDateTime.now();
    }

    public Code(String code, LocalDateTime dateTime) {
        this.code = code;
        this.date = dateTime;
    }

    public Code(String code, LocalDateTime date, Integer id) {
        this.code = code;
        this.date = date;
    }

    public Code(String code, String id, LocalDateTime date, Integer time, Integer views) {
        this.code = code;
        this.uuid = id;
        this.date = date;
        this.time = time;
        this.views = views;
    }

    public Code(String code, String uuid, LocalDateTime date, Integer time, Integer views, Boolean hidden) {
        this.code = code;
        this.uuid = uuid;
        this.date = date;
        this.time = time;
        this.views = views;
        this.hidden = hidden;
    }

    // getters and setters:

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        return this.date.format(formatter);
    }

    public LocalDateTime getDateUnformatted() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean isHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
}
