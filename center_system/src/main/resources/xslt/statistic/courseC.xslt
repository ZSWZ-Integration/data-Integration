<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="C系统全部课程信息/课程列表C/课程信息C">
            <课程信息>
                <课程编号><xsl:value-of select="课程编号C"/></课程编号>
                <课程名><xsl:value-of select="课程名C"/></课程名>
                <授课教师><xsl:value-of select="授课教师C"/></授课教师>
                <课程学分><xsl:value-of select="课程学分C"/></课程学分>
                <选课人数><xsl:value-of select="选课人数C"/></选课人数>
            </课程信息>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>