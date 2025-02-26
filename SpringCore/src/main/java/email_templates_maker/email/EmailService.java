package email_templates_maker.email;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.mail.internet.MimeMessage;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Service
public class EmailService
{
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private FreeMarkerConfigurer freemarkerConfig;

    public void sendWelcomeEmail(EmailDTO emailDTO,
                                 boolean sendEmail)
    {
        System.out.println("##### Started sending welcome email ####");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try
        {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            String templateContent = FreeMarkerTemplateUtils
                    .processTemplateIntoString(freemarkerConfig.getConfiguration()
                                    .getTemplate("/email/welcome.ftlh"),
                            emailDTO.getEmailData());

            System.out.println("-".repeat(120));
            System.out.println(templateContent);
            System.out.println("-".repeat(120));

            helper.setTo(emailDTO.getTo());
            helper.setSubject(emailDTO.getSubject());
            helper.setText(templateContent, true);
            if (sendEmail) {
                mailSender.send(mimeMessage);
            }

            System.out.println("######## Welcome email sent ######");
        } catch (Exception exc) {
            System.out.println("Sending welcome email failed, check log...");
            exc.printStackTrace();
            System.exit(0);
        }
    }

    public void generateEmailMessage()
    {
        final String delimiter = "=".repeat(160);
        System.out.println(delimiter);

        try
        {
            var object = Map.ofEntries(Map.entry("assetSymbol", "USDT"));
            final Map<String, Object> templateParameters = Map.ofEntries(
                    Map.entry("object", object)
            );
            final Template subjectTemplate = freemarkerConfig.getConfiguration()
                    .getTemplate("/email/allocatedAssetsSubject.ftl");
            String templateContent = FreeMarkerTemplateUtils
                    .processTemplateIntoString(subjectTemplate, templateParameters);
            System.out.println(templateContent);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

        System.out.println(delimiter);

        try
        {
            var object = Map.ofEntries(
                    Map.entry("assetSymbol", "USDT"),
                    Map.entry("network", "Binance")
            );
            final Map<String, Object> templateParameters = Map.ofEntries(
                Map.entry("object", object),
                Map.entry("createdValues", "{SOMETHING}")
            );
            final Template subjectTemplate = freemarkerConfig.getConfiguration()
                    .getTemplate("/email/allocatedAssetsBody.ftl");
            String templateContent = FreeMarkerTemplateUtils
                    .processTemplateIntoString(subjectTemplate, templateParameters);

            System.out.println(templateContent);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
