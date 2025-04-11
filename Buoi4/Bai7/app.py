import os

# Đọc biến môi trường APP_ENV (nếu không có thì mặc định là "undefined")
app_env = os.getenv("APP_ENV", "undefined")

print(f"Application is running in environment: {app_env}")
