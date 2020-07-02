<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="A系统全部课程信息/课程列表A/课程信息A">
            <课程信息>
                <课程编号><xsl:value-of select="课程编号A"/></课程编号>
                <课程名><xsl:value-of select="课程名A"/></课程名>
                <授课教师><xsl:value-of select="授课教师A"/></授课教师>
                <课程学分><xsl:value-of select="课程学分A"/></课程学分>
                <选课人数><xsl:value-of select="选课人数A"/></选课人数>
            </课程信息>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>