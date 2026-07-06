# WORKSPACE TASK MANAGER (TODO LIST APPLICATION)

Dự án này là bài giải cho đề bài tuyển dụng vị trí **Intern Developer** (Thời gian thực hiện: 02 ngày). Ứng dụng quản lý công việc toàn diện, sở hữu giao diện bảng điều khiển (Dashboard UI) hiện đại, hỗ trợ tìm kiếm bất đồng bộ, lọc trạng thái, phân trang dữ liệu và kiểm thử tự động (Unit Test).

---

## Hệ Thống Công Nghệ Sử Dụng (Tech Stack)

### Backend (Mã nguồn: `todo-list-backend`)
* **Ngôn ngữ & Framework:** Java 25 / Spring Boot 3.x
* **Quản lý dữ liệu:** Spring Data JPA / Cơ sở dữ liệu **H2 In-Memory** (Tự động khởi tạo cấu trúc bảng, không cần cài đặt cấu hình DB bên ngoài).
* **Kiểm thử (Testing):** JUnit 5 / Mockito (Đảm bảo độ tin cậy logic tầng Service).
* **Công cụ hỗ trợ:** Lombok, Jakarta Validation.

### Frontend (Mã nguồn: `todo-list-frontend`)
* **Ngôn ngữ & Framework:** Vue 3 (Composition API / `<script setup>`) + **TypeScript** (An toàn kiểu dữ liệu).
* **CSS Framework:** Tailwind CSS (Giao diện Clean & Responsive 100% trên thiết bị di động).
* **Kết nối API:** Axios.

---

## Kiến Trúc & Cấu Trúc Mã Nguồn (Project Architecture)

Dự án được tổ chức tách biệt hoàn toàn giữa Client và Server nhằm tăng tính bảo trì:

```todo-list
├── todo-list-backend/               # [BACKEND SPRING BOOT]
│   ├── src/main/java/org/example/todolistbackend/
│   │   ├── controller/restapi/     # Nhận Request từ Client, ánh xạ API Endpoints
│   │   ├── dto/                    # Data Transfer Object (TodoRequest, TodoResponse, ApiResponse)
│   │   ├── entity/                 # Cấu trúc thực thể Todo mapping xuống DB (Sử dụng UUID)
│   │   ├── exception/              # Bộ xử lý ngoại lệ tập trung (Global Exception Handler)
│   │   ├── repository/             # Tương tác cơ sở dữ liệu với các dẫn xuất Spring Data JPA
│   │   └── service/imp/            # Xử lý logic nghiệp vụ chính (Business Logic)
│   └── src/test/java/...           # Hệ thống Unit Test tự động cho Service
│
└── todo-list-frontend/              # [FRONTEND VUE 3 + TS]
    ├── src/components/             # Các thành phần giao diện Dashboard tái sử dụng
    ├── src/models/                  # Định nghĩa Interface TypeScript đồng bộ JSON Backend
    ├── src/App.vue                 # Luồng hiển thị chính của ứng dụng
    └── tailwind.config.js          # Tùy biến cấu hình Tailwind CSS


## Công nghệ sử dụng

### Backend
- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Maven
- MySQL
- RESTful API

### Frontend
- Vue 3
- TypeScript
- Vite
- Axios
- Tailwind CSS
- SweetAlert2

# Chức năng

## Quản lý công việc

- Hiển thị danh sách công việc
- Thêm công việc
- Chỉnh sửa công việc
- Xóa công việc (Soft Delete)
- Đánh dấu hoàn thành / chưa hoàn thành

## Tìm kiếm & Lọc

- Tìm kiếm theo tiêu đề
- Lọc theo trạng thái
- Kết hợp tìm kiếm và lọc

## Phân trang

- Hiển thị dữ liệu theo trang
- Chuyển trang trước/sau

## Giao diện

- Responsive
- Thiết kế hiện đại bằng TailwindCSS

---

# Cấu trúc dữ liệu

| Thuộc tính | Kiểu dữ liệu |
|------------|--------------|
| id | UUID |
| title | String |
| description | String |
| status | PENDING / COMPLETED |
| createdAt | LocalDateTime |
| updatedAt | LocalDateTime |
| isDeleted | Boolean |

# ⚙️ Cài đặt

## 1. Clone project

```bash
git clone frontend: https://github.com/ThanhLy1603/todo-list-frontend.git
         backend: https://github.com/ThanhLy1603/todo-list-backend.git
```

```bash
cd todo-management
```

---

# 🛠️ Backend

## Cấu hình Database

Tạo database

```sql
CREATE DATABASE todo_list;
```

Cập nhật file

```
backend/src/main/resources/application.properties
```

Ví dụ

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_management
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Chạy Backend

```bash
cd backend
```

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

Backend mặc định chạy tại

```
http://localhost:8080
```

---

# Frontend

Cài đặt package

```bash
cd frontend
```

```bash
npm install
```

Tạo file

```
.env
```

Nội dung

```env
VITE_API_URL=http://localhost:8080/api
```

Chạy project

```bash
npm run dev
```

Frontend mặc định chạy tại

```
http://localhost:5173
```

---

# REST API

| Method | Endpoint | Mô tả |
|----------|---------------------------|------------------------------|
| GET | /api/todos | Lấy danh sách |
| POST | /api/todos | Thêm công việc |
| PUT | /api/todos/{id} | Cập nhật |
| DELETE | /api/todos/{id} | Xóa mềm |
| PATCH | /api/todos/{id}/toggle-status | Đổi trạng thái |

## Query Parameters

```
GET /api/todos

?page=0
&size=5
&search=java
&status=PENDING
```

---

# Kiến trúc

Backend

```
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL
```

Frontend

```
Views
    ↓
Components
    ↓
Service (Axios)
    ↓
REST API
```

---

# Validate

- Không cho phép tiêu đề rỗng
- Kiểm tra độ dài dữ liệu
- Kiểm tra trạng thái hợp lệ
- Xử lý lỗi khi không tìm thấy dữ liệu
- Soft Delete bằng trường `isDeleted`

---

# Điểm nổi bật

- RESTful API
- Soft Delete
- Pagination
- Search
- Filter
- Responsive UI
- TypeScript
- Clean Architecture
- Tách riêng Frontend và Backend
- Mã nguồn dễ mở rộng và bảo trì

---

# Giao diện

Có thể bổ sung ảnh chụp màn hình tại đây:

```
docs/images/home.png
docs/images/create.png
docs/images/edit.png
```

---

# Hướng phát triển

- JWT Authentication
- Role-based Authorization
- Docker
- Docker Compose
- Unit Test
- Integration Test
- CI/CD
- Deploy lên Render hoặc Railway

---

# Tác giả

**Ly Nguyen Thanh**

Email: lynguyenthanh1603@gmail.com

GitHub:

https://github.com/thanhly1603