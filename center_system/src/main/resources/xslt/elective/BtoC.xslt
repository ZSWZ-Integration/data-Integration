<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <C系统学生选课信息>
            <课程编号C><xsl:value-of select="xml/cno"/></课程编号C>
            <学生信息C>
                <学生账号C>account</学生账号C>
                <学生密码C><xsl:value-of select="xml/student/pwd"/></学生密码C>
                <创建日期C>2019-06-30 16:00:00</创建日期C>
                <学生编号C><xsl:value-of select="xml/student/id"/></学生编号C>
                <学生姓名C><xsl:value-of select="xml/student/name"/></学生姓名C>
                <学生性别C><xsl:value-of select="xml/student/sex"/></学生性别C>
            </学生信息C>
            <学生成绩C><xsl:value-of select="xml/grade"/></学生成绩C>
        </C系统学生选课信息>
    </xsl:template>

</xsl:stylesheet>