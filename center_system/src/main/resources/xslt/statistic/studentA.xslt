<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="A系统学生选课信息/学生选课列表A/选课信息A">
            <选课信息>
                <学生编号><xsl:value-of select="学生编号A"/></学生编号>
                <学生姓名><xsl:value-of select="学生姓名A"/></学生姓名>
                <学生性别><xsl:value-of select="学生性别A"/></学生性别>
                <课程编号><xsl:value-of select="课程编号A"/></课程编号>
                <课程名><xsl:value-of select="课程名A"/></课程名>
                <课程成绩><xsl:value-of select="课程成绩A"/></课程成绩>
            </选课信息>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>