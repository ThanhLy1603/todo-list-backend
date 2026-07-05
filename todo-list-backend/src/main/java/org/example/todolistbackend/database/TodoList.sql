CREATE DATABASE TodoList;

USE TodoList;

CREATE TABLE todos (
	id VARCHAR(36) NOT NULL PRIMARY KEY DEFAULT (UUID()),
	title VARCHAR(255) NOT NULL,
	description TEXT,
	status VARCHAR(10) DEFAULT 'PENDING',
	create_at TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE todos;

INSERT INTO todos (title, description, status) VALUES
(
    'Học cơ bản về Java',
    'Hoàn thành kiến thức về biến, vòng lặp, điều kiện và hàm.',
    'COMPLETED'
),
(
    'Luyện tập SQL',
    'Giải 20 câu truy vấn về các mệnh đề JOIN và truy vấn con (subquery).',
    'PENDING'
),
(
    'Xây dựng API NestJS',
    'Tạo các API CRUD cho ứng dụng quản lý công việc (Todo).',
    'PENDING'
),
(
    'Nghiên cứu React',
    'Học về hooks, routing và quản lý trạng thái (state management).',
    'PENDING'
),
(
    'Đọc sách Clean Code',
    'Đọc hết từ chương 1 đến chương 5 của sách Clean Code.',
    'PENDING'
),
(
    'Tập thể dục',
    'Chạy bộ 5 cây số vào buổi tối.',
    'COMPLETED'
),
(
    'Đi chợ mua thực phẩm',
    'Mua rau củ, trái cây, trứng và sữa.',
    'PENDING'
),
(
    'Viết tài liệu kỹ thuật',
    'Chuẩn bị tài liệu API sử dụng Swagger.',
    'PENDING'
),
(
    'Sửa lỗi Đăng nhập',
    'Xử lý lỗi xác thực sau khi mã JWT hết hạn.',
    'PENDING'
),
(
    'Triển khai dự án',
    'Deploy backend lên Render và frontend lên Vercel.',
    'PENDING'
),
(
    'Review Pull Request',
    'Kiểm tra và đánh giá code của đồng nghiệp trước khi merge.',
    'COMPLETED'
),
(
    'Sao lưu cơ sở dữ liệu',
    'Tạo bản sao lưu (backup) cho database production.',
    'COMPLETED'
),
(
    'Cập nhật Dependencies',
    'Nâng cấp các package trong dự án lên phiên bản ổn định mới nhất.',
    'PENDING'
),
(
    'Chuẩn bị bài thuyết trình',
    'Tạo slide cho buổi họp dự án định kỳ hàng tuần.',
    'PENDING'
),
(
    'Học Docker',
    'Thực hành viết Dockerfile và cấu hình Docker Compose.',
    'PENDING'
),
(
    'Tối ưu hóa truy vấn',
    'Cải thiện hiệu năng truy vấn SQL bằng cách sử dụng index.',
    'PENDING'
),
(
    'Kiểm thử REST API',
    'Sử dụng Postman để kiểm tra toàn bộ các endpoint API.',
    'COMPLETED'
),
(
    'Tích hợp phân trang',
    'Thêm tính năng phân trang (pagination) và sắp xếp cho danh sách todo.',
    'PENDING'
),
(
    'Tìm hiểu về Redis',
    'Nghiên cứu các chiến lược lưu trữ bộ nhớ đệm (caching) với Redis.',
    'PENDING'
),
(
    'Lập báo cáo tổng kết',
    'Tóm tắt tiến độ tuần qua và các công việc còn tồn đọng.',
    'PENDING'
);

SELECT * FROM todos;

