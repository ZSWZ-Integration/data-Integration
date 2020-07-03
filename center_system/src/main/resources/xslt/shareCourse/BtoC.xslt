<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="Request/courses/item">
            <课程信息C>
                <课程编号C><xsl:value-of select="id"/></课程编号C>
                <课程名C><xsl:value-of select="name"/></课程名C>
                <授课教师C><xsl:value-of select="teacher"/></授课教师C>
                <课程学分C><xsl:value-of select="credit"/></课程学分C>
                <是否共享C>0</是否共享C>
            </课程信息C>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>