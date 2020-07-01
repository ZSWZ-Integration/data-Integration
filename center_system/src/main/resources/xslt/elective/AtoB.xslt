<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xml>
            <cno><xsl:value-of select="A系统学生选课信息/课程编号A"/></cno>
            <grade><xsl:value-of select="A系统学生选课信息/学生成绩A"/></grade>
            <student>
                <age>20</age>
                <name><xsl:value-of select="A系统学生选课信息/学生信息A/学生姓名A"/></name>
                <id><xsl:value-of select="A系统学生选课信息/学生信息A/学生编号A"/></id>
                <pwd><xsl:value-of select="A系统学生选课信息/学生信息A/学生密码A"/></pwd>
                <sex><xsl:value-of select="A系统学生选课信息/学生信息A/学生性别A"/></sex>
            </student>
        </xml>
    </xsl:template>

</xsl:stylesheet>