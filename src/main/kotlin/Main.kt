import java.io.File

fun main(args: Array<String>) {
    val filesList = arrayListOf<File>()
    searchJpgFiles(File("C:\\Users\\USER\\Downloads\\"),filesList)

    for (file in filesList) {
        println(file.absolutePath)
    }
}

fun searchJpgFiles(rootFile: File ,fileList: ArrayList<File>){
    if(rootFile.isDirectory){
        val listFiles = rootFile.listFiles()
        if (listFiles != null){
            for (file in listFiles) {
                if (file.isDirectory){
                    searchJpgFiles(file,fileList)
                } else {
                    if(file.name.lowercase().endsWith(".jpg")){
                        fileList.add(file)
                    }
                }
            }
        }
    }
}