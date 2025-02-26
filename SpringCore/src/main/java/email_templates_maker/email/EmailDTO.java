package email_templates_maker.email;

import lombok.Data;
import java.util.Map;

@Data
public class EmailDTO {
    private String to;
    private String subject;
    private Map<String, Object> emailData;
}