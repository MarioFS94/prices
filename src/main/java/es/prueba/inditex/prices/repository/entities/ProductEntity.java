package es.prueba.inditex.prices.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Tabla que se creara en la BBDD H2 en tiempo de ejecucion
 * segun los tipos indicados aqui
 */
@IdClass(ProductPK.class)
@Entity
@Table(name = "PRICES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Id
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Id
    @Column(name = "PRICE_LIST")
    private Integer rate;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double pvp;

    @Column(name = "CURRENCY")
    private String currency;
}
