<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="C系统学生选课信息/学生选课列表C/选课信息C">
            <选课信息>
                <学生编号><xsl:value-of select="学生编号C"/></学生编号>
                <学生姓名><xsl:value-of select="学生姓名C"/></学生姓名>
                <学生性别><xsl:value-of select="学生性别C"/></学生性别>
                <课程编号><xsl:value-of select="课程编号C"/></课程编号>
                <课程名><xsl:value-of select="课程名C"/></课程名>
                <课程成绩><xsl:value-of select="课程成绩C"/></课程成绩>
            </选课信息>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>