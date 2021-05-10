package tests.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddToCard {

    @JsonProperty("EnteredQuantity")
    private int quantity;

    public AddToCard(int numCard) { this.quantity = numCard;}

}