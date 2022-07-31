import java.io.File;
import java.io.FilenameFilter;

public class App {
    public static void main(String[] args) throws Exception {
        File f1=new File("../README.md");
        print("File Name: "+f1.getName());
        print("File Path: "+f1.getPath());
        print("Abs. Path: "+f1.getAbsolutePath());
        print("Parent: "+f1.getParent());
        print("File Exist: "+f1.exists());
        print("Writeable: "+f1.canWrite());
        print("Readable: "+f1.canRead());
        print("Is Directory: "+f1.isDirectory());
        print("Is File: "+f1.isFile());
        print("Is Absolute: "+f1.isAbsolute());
        print("File Last Modified: "+f1.lastModified());
        print("File Size: "+f1.length()+" Bytes");
        print("");
        String dirname="../src/";
        File f2=new File(dirname);
        if (f2.isDirectory()) {
            print("Directory of: "+dirname);
            String s[]=f2.list();
            for (int i=0; i<s.length; i++) {
                File f=new File(dirname+"/"+s[i]);
                if (f.isDirectory()) {
                    print(s[0]+" is a directory");
                } else {
                    print(s[i]+" is a file");
                }
            }
        } else {
            print(dirname+" is not a directory");
        }
        print("");
        File f3=new File(dirname);
        OnlyExt only=new OnlyExt("class");
        String sl[]=f3.list(only);
        for (int i=0; i<sl.length; i++) {
            print(sl[i]);
        }
    }

    static void print(String s) {
        System.out.println(s);
    }
}

class OnlyExt implements FilenameFilter {
    String ext;

    OnlyExt(String ext) {
        this.ext="."+ext;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}