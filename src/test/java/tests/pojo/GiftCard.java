package tests.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiftCard {

    @JsonProperty("Message")
    private String msg;

    @JsonProperty("RecipientEmail")
    private String recMail;

    @JsonProperty("RecipientName")
    private String recName;

    @JsonProperty("SenderName")
    private String sendName;

    @JsonProperty("SenderEmail")
    private String sendMail;

    public GiftCard() {
        Faker faker1 = new Faker();
        Faker faker2 = new Faker();
        this.msg = faker1.lorem().sentences(1).toString();
        this.recMail = faker2.internet().emailAddress();
        this.recName = faker2.name().firstName();
        this.sendName = faker1.name().firstName();
        this.sendMail = faker2.internet().emailAddress();
    }
}