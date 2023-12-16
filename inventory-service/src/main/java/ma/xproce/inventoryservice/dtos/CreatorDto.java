package ma.xproce.inventoryservice.dtos;

import lombok.*;
import ma.xproce.inventoryservice.dao.entities.Video;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@ToString
public class CreatorDto {
private Float id;
private  String name;
private String email;
    private List<Video> videos;
}
