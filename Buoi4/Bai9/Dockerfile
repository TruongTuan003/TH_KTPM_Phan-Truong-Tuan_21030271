# Sử dụng Redis image chính thức
FROM redis:latest

# Copy file cấu hình vào container
COPY redis.conf /usr/local/etc/redis/redis.conf

# Chạy Redis với cấu hình custom
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]
