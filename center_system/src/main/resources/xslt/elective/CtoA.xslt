<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <A系统学生选课信息>
            <课程编号A><xsl:value-of select="C系统学生选课信息/课程编号C"/></课程编号A>
            <学生信息A>
                <学生账号A><xsl:value-of select="C系统学生选课信息/学生信息C/学生账号C"/></学生账号A>
                <学生密码A><xsl:value-of select="C系统学生选课信息/学生信息C/学生密码C"/></学生密码A>
                <创建日期A>2019-06-30 16:00:00</创建日期A>
                <学生编号A><xsl:value-of select="C系统学生选课信息/学生信息C/学生编号C"/></学生编号A>
                <学生姓名A><xsl:value-of select="C系统学生选课信息/学生信息C/学生姓名C"/></学生姓名A>
                <学生性别A><xsl:value-of select="C系统学生选课信息/学生信息C/学生性别C"/></学生性别A>
            </学生信息A>
            <学生成绩A><xsl:value-of select="C系统学生选课信息/学生成绩C"/></学生成绩A>
        </A系统学生选课信息>
    </xsl:template>

</xsl:stylesheet>