<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="C院系共享课程信息/课程列表C/课程信息C">
            <item>
                <id><xsl:value-of select="课程编号C"/></id>
                <name><xsl:value-of select="课程名C"/></name>
                <credit><xsl:value-of select="课程学分C"/></credit>
                <teacher><xsl:value-of select="授课教师C"/></teacher>
                <campus>仙林</campus>
                <share>0</share>
            </item>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>