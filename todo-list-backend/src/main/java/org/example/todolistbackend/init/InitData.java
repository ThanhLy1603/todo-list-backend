package org.example.todolistbackend.init;

import lombok.RequiredArgsConstructor;
import org.example.todolistbackend.entity.Todo;
import org.example.todolistbackend.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {
    private final TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        initTodo();
    }

    public void initTodo() {
        List<Todo> todos = List.of(
                new Todo(null, "Học cơ bản về Java", "Hoàn thành kiến thức về biến, vòng lặp, điều kiện và hàm.", "COMPLETED", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Luyện tập SQL", "Giải 20 câu truy vấn về các mệnh đề JOIN và truy vấn con (subquery).", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Xây dựng API NestJS", "Tạo các API CRUD cho ứng dụng quản lý công việc (Todo).", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Nghiên cứu React", "Học về hooks, routing và quản lý trạng thái (state management).", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Đọc sách Clean Code", "Đọc hết từ chương 1 đến chương 5 của sách Clean Code.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Tập thể dục", "Chạy bộ 5 cây số vào buổi tối.", "COMPLETED", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Đi chợ mua thực phẩm", "Mua rau củ, trái cây, trứng và sữa.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Viết tài liệu kỹ thuật", "Chuẩn bị tài liệu API sử dụng Swagger.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Sửa lỗi Đăng nhập", "Xử lý lỗi xác thực sau khi mã JWT hết hạn.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Triển khai dự án", "Deploy backend lên Render và frontend lên Vercel.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Review Pull Request", "Kiểm tra và đánh giá code của đồng nghiệp trước khi merge.", "COMPLETED", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Sao lưu cơ sở dữ liệu", "Tạo bản sao lưu (backup) cho database production.", "COMPLETED", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Cập nhật Dependencies", "Nâng cấp các package trong dự án lên phiên bản ổn định mới nhất.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Chuẩn bị bài thuyết trình", "Tạo slide cho buổi họp dự án định kỳ hàng tuần.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Học Docker", "Thực hành viết Dockerfile và cấu hình Docker Compose.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Tối ưu hóa truy vấn", "Cải thiện hiệu năng truy vấn SQL bằng cách sử dụng index.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Kiểm thử REST API", "Sử dụng Postman để kiểm tra toàn bộ các endpoint API.", "COMPLETED", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Tích hợp phân trang", "Thêm tính năng phân trang (pagination) và sắp xếp cho danh sách todo.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Tìm hiểu về Redis", "Nghiên cứu các chiến lược lưu trữ bộ nhớ đệm (caching) với Redis.", "PENDING", LocalDateTime.now(), LocalDateTime.now()),
                new Todo(null, "Lập báo cáo tổng kết", "Tóm tắt tiến độ tuần qua và các công việc còn tồn đọng.", "PENDING", LocalDateTime.now(), LocalDateTime.now())
        );

        if (todoRepository.findAll().isEmpty()) {
            todoRepository.saveAll(todos);
        } else {
            System.out.println("Bảng To Do đã được khởi tạo rồi");
        }
    }
}
