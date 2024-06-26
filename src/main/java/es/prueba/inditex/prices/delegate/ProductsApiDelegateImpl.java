package es.prueba.inditex.prices.delegate;

import es.prueba.inditex.prices.api.ProductsApiDelegate;
import es.prueba.inditex.prices.model.PriceRequestDto;
import es.prueba.inditex.prices.model.PriceResponseDTO;
import es.prueba.inditex.prices.service.ProductsService;
import es.prueba.inditex.prices.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParametersException;

@Service
public class ProductsApiDelegateImpl implements ProductsApiDelegate {

    private final ProductsService productsService;

    public ProductsApiDelegateImpl(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public ResponseEntity<PriceResponseDTO> getProductData(Integer idProduct, Integer idBrand, String applicationDate) {
        //build request object and call service
        PriceRequestDto requestDto = new PriceRequestDto(idProduct, idBrand, validateFormat(applicationDate));

        PriceResponseDTO productData = productsService.getProductData(requestDto);

        return ResponseEntity.ok(productData);
    }

    /**
     * Date string format validations
     * @param applicationDate the input date
     * @return  the result date
     */
    private String validateFormat(String applicationDate) {

        StringBuilder builder = new StringBuilder(applicationDate);
        if (applicationDate.length() < 10){
            throw new MalformedParametersException(Constants.PARAMETER_ERROR);
        }
        if (applicationDate.length() > 10 && applicationDate.charAt(10) != ' ') {
            builder.setCharAt(10, ' ');
        }
        if (applicationDate.length() == 16){
            builder.append(".00");
        }
        if (applicationDate.length() == 12){
            builder.append(".00.00");
        }
        return builder.toString();
    }
}
