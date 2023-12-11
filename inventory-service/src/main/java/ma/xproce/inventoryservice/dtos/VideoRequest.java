package ma.xproce.inventoryservice.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VideoRequest {
    private Long id;
private String name;
private String url;
private  String description;
private String datePublication;
private CreatorRequest creator;
}
