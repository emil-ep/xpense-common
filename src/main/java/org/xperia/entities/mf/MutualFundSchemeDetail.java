package org.xperia.entities.mf;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity(name = "mf_scheme_detail")
@NoArgsConstructor
@Getter
@Setter
@Access(AccessType.FIELD)
public class MutualFundSchemeDetail {

    @Id
    private String code;

    private String type;

    private String category;

    private String fundHouse;

    private String name;

    private Double growth;

    private Double growthPercent;

    @Column(columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private String payload;

    public MutualFundSchemeDetail(String code, String type, String category, String fundHouse, String name,
                                  String payload, Double growth, Double growthPercent){
        this.code = code;
        this.type = type;
        this.category = category;
        this.fundHouse = fundHouse;
        this.name = name;
        this.payload = payload;
        this.growth = growth;
        this.growthPercent = growthPercent;
    }
}
