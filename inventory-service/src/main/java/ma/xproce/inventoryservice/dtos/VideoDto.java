package ma.xproce.inventoryservice.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VideoDto {
    private Float id;
private String name;
private String url;
private  String description;
private String datePublication;
private CreatorDto creator;
}
