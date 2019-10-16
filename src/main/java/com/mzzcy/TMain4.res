Classfile /home/mzzcy/code/code2/mzTest/src/main/java/com/mzzcy/TMain4.class
  Last modified Oct 15, 2019; size 493 bytes
  MD5 checksum 3628eff8ec313cac1884241c68cdba01
  Compiled from "TMain4.java"
public class com.mzzcy.TMain4
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#21         // java/lang/Object."<init>":()V
   #2 = Fieldref           #22.#23        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Class              #24            // com/mzzcy/TMain4
   #4 = Methodref          #25.#26        // java/io/PrintStream.println:(I)V
   #5 = Class              #27            // java/lang/Object
   #6 = Utf8               zz
   #7 = Utf8               Ljava/lang/String;
   #8 = Utf8               ConstantValue
   #9 = String             #28            // abc
  #10 = Utf8               zznum
  #11 = Utf8               I
  #12 = Integer            123
  #13 = Utf8               <init>
  #14 = Utf8               ()V
  #15 = Utf8               Code
  #16 = Utf8               LineNumberTable
  #17 = Utf8               main
  #18 = Utf8               ([Ljava/lang/String;)V
  #19 = Utf8               SourceFile
  #20 = Utf8               TMain4.java
  #21 = NameAndType        #13:#14        // "<init>":()V
  #22 = Class              #29            // java/lang/System
  #23 = NameAndType        #30:#31        // out:Ljava/io/PrintStream;
  #24 = Utf8               com/mzzcy/TMain4
  #25 = Class              #32            // java/io/PrintStream
  #26 = NameAndType        #33:#34        // println:(I)V
  #27 = Utf8               java/lang/Object
  #28 = Utf8               abc
  #29 = Utf8               java/lang/System
  #30 = Utf8               out
  #31 = Utf8               Ljava/io/PrintStream;
  #32 = Utf8               java/io/PrintStream
  #33 = Utf8               println
  #34 = Utf8               (I)V
{
  public com.mzzcy.TMain4();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 8: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: bipush        123
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
         8: return
      LineNumberTable:
        line 15: 0
        line 16: 8
}
SourceFile: "TMain4.java"
