<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="A院系共享课程信息/课程列表A/课程信息A">
            <item>
                <id><xsl:value-of select="课程编号A"/></id>
                <name><xsl:value-of select="课程名A"/></name>
                <credit><xsl:value-of select="课程学分A"/></credit>
                <teacher><xsl:value-of select="授课教师A"/></teacher>
                <campus>鼓楼</campus>
                <share>0</share>
            </item>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>