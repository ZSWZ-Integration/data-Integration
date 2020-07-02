<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="A院系共享课程信息/课程列表A/课程信息A">
            <课程信息C>
                <课程编号C><xsl:value-of select="课程编号A"/></课程编号C>
                <课程名C><xsl:value-of select="课程名A"/></课程名C>
                <授课教师C><xsl:value-of select="授课教师A"/></授课教师C>
                <课程时间C><xsl:value-of select="课程时间A"/></课程时间C>
                <课程学分C><xsl:value-of select="课程学分A"/></课程学分C>
                <是否共享C><xsl:value-of select="是否共享A"/></是否共享C>
                <所属学院C>A</所属学院C>
            </课程信息C>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>