package kz.downtown.jar.dtos;

import lombok.Data;

@Data
public class TextInsertUpdateDTO {
    private Long id;
    private String textName;
    private String text;
}
