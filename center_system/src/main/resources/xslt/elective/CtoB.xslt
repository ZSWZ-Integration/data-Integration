<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xml>
            <cno><xsl:value-of select="C系统学生选课信息/课程编号C"/></cno>
            <grade><xsl:value-of select="A系统学生选课信息/学生成绩C"/></grade>
            <student>
                <age>20</age>
                <name><xsl:value-of select="A系统学生选课信息/学生信息C/学生姓名C"/></name>
                <id><xsl:value-of select="A系统学生选课信息/学生信息C/学生编号C"/></id>
                <pwd><xsl:value-of select="A系统学生选课信息/学生信息C/学生密码C"/></pwd>
                <sex><xsl:value-of select="A系统学生选课信息/学生信息C/学生性别C"/></sex>
            </student>
        </xml>
    </xsl:template>

</xsl:stylesheet>