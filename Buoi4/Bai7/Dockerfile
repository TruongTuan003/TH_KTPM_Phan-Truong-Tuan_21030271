# Sử dụng image Python
FROM python:3.11-slim

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép file Python vào container
COPY app.py .

# Thiết lập biến môi trường mặc định
ENV APP_ENV=development

# Lệnh chạy chương trình
CMD ["python", "app.py"]
