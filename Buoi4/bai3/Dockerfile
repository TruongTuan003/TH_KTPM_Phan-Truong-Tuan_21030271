# Sử dụng node:18-alpine làm base image
FROM node:18-alpine

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép package.json và lock file trước để cài đặt dependency trước (tăng hiệu quả cache)
COPY package*.json ./

# Cài đặt các dependency
RUN npm install

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng React
RUN npm run build

# Cài đặt một web server đơn giản để serve React (dùng serve)
RUN npm install -g serve

# Mở port 3000 (port mặc định khi dùng serve)
EXPOSE 3000

# Lệnh khởi chạy container
CMD ["serve", "-s", "build", "-l", "3000"]
