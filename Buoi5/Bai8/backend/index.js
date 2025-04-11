const express = require('express');
const mysql = require('mysql');

const app = express();

const db = mysql.createConnection({
  host: process.env.DB_HOST || 'localhost',
  user: process.env.DB_USER || 'user',
  password: process.env.DB_PASSWORD || 'password',
  database: process.env.DB_NAME || 'testdb'
});

db.connect(err => {
  if (err) {
    console.error('Lỗi kết nối DB:', err);
    return;
  }
  console.log('Kết nối MySQL thành công!');
});

app.get('/', (req, res) => {
  db.query('SELECT NOW() AS now', (err, result) => {
    if (err) return res.status(500).send('Lỗi DB');
    res.send(`Giờ hiện tại: ${result[0].now}`);
  });
});

app.listen(3000, () => {
  console.log('Node.js server chạy tại http://localhost:3000');
});
