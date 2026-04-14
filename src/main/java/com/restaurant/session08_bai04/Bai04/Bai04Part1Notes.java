package com.restaurant.session08_bai04.Bai04;

/*
PHẦN 1 - PHÂN TÍCH VÀ ĐỀ XUẤT ĐA GIẢI PHÁP
1) Input/Output
- Input: DTO đăng ký gồm 3 trường: username, password, confirmPassword
- Output:
  + Hợp lệ: cho phép xử lý tiếp
  + Không hợp lệ: trả lỗi validation "Mật khẩu và xác nhận mật khẩu không khớp"

2) Giải pháp 1 - Xử lý thủ công trong Controller/Service (if-else)
- Ý tưởng:
  + if (password == null || confirmPassword == null) => báo lỗi.
  + else if (!password.equals(confirmPassword)) => báo lỗi.
  + else => hợp lệ.
- Ưu điểm: dễ hiểu, làm nhanh cho bài nhỏ.
- Nhược điểm: dễ lặp code, khó tái sử dụng, trộn business + validation.

3) Giải pháp 2 - Custom Validation cấp Class
- Ý tưởng:
  + Tạo @ValidPasswordMatch đặt trên class DTO.
  + ConstraintValidator<ValidPasswordMatch, RegisterForm> so sánh 2 field.
  + Dùng Objects.equals(password, confirmPassword) để tránh NullPointerException.
- Ưu điểm: tách riêng concern, tái sử dụng tốt, dễ bảo trì.
- Nhược điểm: cần tạo thêm annotation + validator (boilerplate ban đầu).

4) Lựa chọn
- Chọn giải pháp 2 vì phù hợp nguyên tắc Separation of Concerns,
  dễ tái sử dụng cho các form đổi mật khẩu/đổi PIN/xác nhận email sau này.
*/

public final class Bai04Part1Notes {

    private Bai04Part1Notes() {
    }
}