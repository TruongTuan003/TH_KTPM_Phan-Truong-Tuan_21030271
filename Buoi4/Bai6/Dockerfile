# Stage 1: Build
FROM node:18 AS builder

WORKDIR /app
COPY package*.json ./
RUN npm install

COPY . .

# Stage 2: Run
FROM node:18-alpine

WORKDIR /app

# Copy từ stage 1
COPY --from=builder /app /app

# Mở cổng app
EXPOSE 3000

# Chạy ứng dụng
CMD ["npm", "start"]
