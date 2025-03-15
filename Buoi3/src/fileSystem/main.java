package fileSystem;
public class main {
    public static void main(String[] args) {
        // Tạo thư mục gốc
        Folder root = new Folder("Root");

        // Tạo thư mục con
        Folder documents = new Folder("Documents");
        Folder pictures = new Folder("Pictures");

        // Tạo tập tin
        File file1 = new File("Resume.pdf");
        File file2 = new File("Notes.txt");
        File image1 = new File("photo1.jpg");
        File image2 = new File("photo2.png");

        // Thêm tập tin vào thư mục Documents
        documents.add(file1);
        documents.add(file2);

        // Thêm tập tin vào thư mục Pictures
        pictures.add(image1);
        pictures.add(image2);

        // Thêm các thư mục vào thư mục gốc
        root.add(documents);
        root.add(pictures);

        // Hiển thị toàn bộ cấu trúc cây
        root.display("");
    }
}