<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="Request/statisticCourses/item">
            <课程信息>
                <课程编号><xsl:value-of select="id"/></课程编号>
                <课程名><xsl:value-of select="name"/></课程名>
                <授课教师><xsl:value-of select="teacher"/></授课教师>
                <课程学分><xsl:value-of select="credit"/></课程学分>
                <选课人数><xsl:value-of select="count"/></选课人数>
            </课程信息>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>