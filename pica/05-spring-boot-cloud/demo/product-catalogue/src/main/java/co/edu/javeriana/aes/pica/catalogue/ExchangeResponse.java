package co.edu.javeriana.aes.pica.catalogue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResponse {

    private String host;
    private String to;
    private double newValue;
}