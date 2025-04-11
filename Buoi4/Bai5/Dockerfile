# Sử dụng image Go chính thức để build app
FROM golang:1.21-alpine AS build

# Tạo thư mục làm việc trong container
WORKDIR /app

# Copy toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng Go
RUN go build -o app

# Image chạy thực tế, dùng Alpine để nhẹ
FROM alpine:latest

WORKDIR /root/

# Copy binary từ giai đoạn build sang
COPY --from=build /app/app .

# Mở cổng 8080
EXPOSE 8080

# Lệnh chạy chương trình
CMD ["./app"]
