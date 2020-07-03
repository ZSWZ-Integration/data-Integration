<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <C系统学生选课信息>
            <课程编号C><xsl:value-of select="A系统学生选课信息/课程编号A"/></课程编号C>
            <学生信息C>
                <学生账号C><xsl:value-of select="A系统学生选课信息/学生信息A/学生账号A"/></学生账号C>
                <学生密码C><xsl:value-of select="A系统学生选课信息/学生信息A/学生密码A"/></学生密码C>
                <学生编号C><xsl:value-of select="A系统学生选课信息/学生信息A/学生编号A"/></学生编号C>
                <学生姓名C><xsl:value-of select="A系统学生选课信息/学生信息A/学生姓名A"/></学生姓名C>
                <学生性别C><xsl:value-of select="A系统学生选课信息/学生信息A/学生性别A"/></学生性别C>
            </学生信息C>
            <学生成绩C><xsl:value-of select="A系统学生选课信息/学生成绩A"/></学生成绩C>
        </C系统学生选课信息>
    </xsl:template>

</xsl:stylesheet>