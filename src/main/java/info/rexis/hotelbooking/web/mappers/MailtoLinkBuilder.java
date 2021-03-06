package info.rexis.hotelbooking.web.mappers;

import info.rexis.hotelbooking.services.dto.EmailDto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MailtoLinkBuilder {
    public String buildOrNullIgnoringExceptions(EmailDto emailDto) {
        try {
            String encodedBody = urlEncodeUtf8(emailDto.getBody());
            String encodedSubject = urlEncodeUtf8(emailDto.getSubject());
            return "mailto:" + emailDto.getRecipient() + "?subject=" + encodedSubject + "&body=" + encodedBody;
        } catch (Exception ignore) {
            // ok, we won't offer the link in this case
            return null;
        }
    }

    protected String urlEncodeUtf8(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");
    }
}
