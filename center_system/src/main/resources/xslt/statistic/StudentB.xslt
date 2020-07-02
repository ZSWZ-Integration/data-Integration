<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="Request/statisticStudents/item">
            <选课信息>
                <学生编号><xsl:value-of select="id"/></学生编号>
                <学生姓名><xsl:value-of select="name"/></学生姓名>
                <学生性别><xsl:value-of select="sex"/></学生性别>
                <课程编号><xsl:value-of select="cno"/></课程编号>
                <课程名><xsl:value-of select="cname"/></课程名>
                <课程成绩><xsl:value-of select="grade"/></课程成绩>
            </选课信息>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>