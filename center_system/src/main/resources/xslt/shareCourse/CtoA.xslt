<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="C院系共享课程信息/课程列表C/课程信息C">
            <课程信息A>
                <课程编号A><xsl:value-of select="课程编号C"/></课程编号A>
                <课程名A><xsl:value-of select="课程名C"/></课程名A>
                <授课教师A><xsl:value-of select="授课教师C"/></授课教师A>
                <课程时间A>50</课程时间A>
                <课程学分A><xsl:value-of select="课程学分C"/></课程学分A>
                <是否共享A><xsl:value-of select="是否共享C"/></是否共享A>
                <所属学院A>C</所属学院A>
            </课程信息A>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>