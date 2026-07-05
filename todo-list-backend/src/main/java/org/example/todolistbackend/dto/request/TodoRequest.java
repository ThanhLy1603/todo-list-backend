package org.example.todolistbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoRequest {

    @NotBlank(message = "Tên công việc không được để trống")
    @Size(max = 255, message = "Tên công việc không được quá 255 ký tự")
    private String title;

    private String description;

    @Size(max = 20, message = "Trạng thái không hợp lệ")
    private String status;
}
