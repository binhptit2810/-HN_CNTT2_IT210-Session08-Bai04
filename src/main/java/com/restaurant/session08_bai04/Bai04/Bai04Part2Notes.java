package com.restaurant.session08_bai04.Bai04;

/*
Tiêu chí	                Giải pháp 1: if-else (Controller/Service)	        Giải pháp 2: Custom Validation (Class-Level)

Boilerplate code	        Ít code ban đầu, viết nhanh	                        Nhiều hơn (phải tạo annotation + validator)

Khả năng tái sử dụng        Thấp (mỗi form phải viết lại)	                    Cao (dùng lại cho nhiều form khác)

Separation of Concerns	    Vi phạm (trộn validation vào business logic)	    Đúng chuẩn (tách validation riêng)

Dễ bảo trì	                Khó (logic rải rác nhiều nơi)	                    Dễ (tập trung 1 chỗ)

Khả năng mở rộng	        Kém	                                                Tốt

Nguy cơ lỗi 	            Dễ xảy ra nếu quên check null	                    Kiểm soát tốt bằng Objects.equals()

Tính chuyên nghiệp   	    Không khuyến khích	                                Best practice
 */