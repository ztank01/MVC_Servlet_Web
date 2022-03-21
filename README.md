# Hướng dẫn cài đặt
## Yêu cầu 
- jre1.8.0_191
- jdk1.8.0_191
- sqljdbc_9.4
- apache-maven-3.6.0
- apache-tomcat-8.5.34
- Có thể chạy trên Eclipse 2018-09 (4.9.0)
## Hướng dẫn mở port 1433 để kết nối vào database
Có thể tham khảo link:https://kienthuclaptrinh.vn/2012/07/24/7-buoc-de-mo-port-1433-cho-ms-sql-server/
## Hướng dẫn điều chỉnh thông tin để kết nối vào database
Thay đổi nội dung các file:
- trinhtruong2k1.io.seller.connection.DBConnect
- trinhtruong2k1.io.seller.DaoImpl.AbstractDao
- vn.iostar.connection.DBConnect
- vn.VietTect.Connection.DBConnect

# Giới thiệu code chức năng
- vn.Vietshop thực thi các chức năng các chức năng khách
- vn.iotstar thực thi các chức năng các chức năng admin
- trinhtruong2k1.io.seller thực thi các chức năng của seller
