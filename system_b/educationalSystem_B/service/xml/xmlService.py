import xml.etree.ElementTree as ET
import xml.dom.minidom as minidom

import dicttoxml
from encoder import XML2Dict
import dict2xml
from xml.dom.minidom import parseString
import requests


class Dict(dict):
    __setattr__ = dict.__setitem__
    __getattr__ = dict.__getitem__

def objectToXml2(obj):  #对象里包含list
    dic = objectToDict(obj)
    xml = dicttoxml.dicttoxml(dic, custom_root="Request", root=True).decode("utf-8")
    return xml

def objectToXml(obj):
    dic=objectToDict(obj)
    print(dic)
    xml="<xml>"+trans_dict_to_xml(dic)+"</xml>";
    return xml

def xmlToObject(xml):
    dic=trans_xml_to_dict(xml)
    obj=dictToObject(dic)
    return obj

def dictToObject(dictObj):
    if not isinstance(dictObj, dict):
        return dictObj
    inst = Dict()
    for k, v in dictObj.items():
        inst[k] = dictToObject(v)
    return inst

def objectToDict(object):
    try:
        root_dict = object.__dict__
        for key in root_dict.keys():
            val = root_dict[key]
            if isinstance(val, list):
                converted_list = []
                for item in val:
                    converted_list.append(objectToDict(item))
                val = converted_list
            root_dict[key] = objectToDict(val)
        return root_dict
    except BaseException as e:
        #print(e)
        return object






def trans_dict_to_xml(data):
    """
    将 dict 对象转换成微信支付交互所需的 XML 格式数据
    :param data: dict 对象
    :return: xml 格式数据
    """
    xml = []
    for k in sorted(data.keys()):
        v = data.get(k)
        # if(v.find("{")!=-1):
        #     eval(v)
        if isinstance(v, dict):
            v=trans_dict_to_xml(v)
        if k == 'detail' and not v.startswith('<![CDATA['):
            v = '<![CDATA[{}]]>'.format(v)
        xml.append('<{key}>{value}</{key}>'.format(key=k, value=v))
    return '{}'.format(''.join(xml))


def trans_xml_to_dict(xml):
    """
    将微信支付交互返回的 XML 格式数据转化为 Python Dict 对象

    :param xml: 原始 XML 格式数据
    :return: dict 对象
    """

    # soup = BeautifulSoup(xml, features='xml')
    # xml = soup.find('xml')
    # if not xml:
    #     return {}

    # 将 XML 数据转化为 Dict
    # msg = {}
    # root_elem = ET.fromstring(xml)
    # print(root_elem)
    # for ch in root_elem:
    #     msg[ch.tag] = ch.text
    # return msg

    x = XML2Dict()
    d = x.parse(xml)
    return d

def postRequest(xml,url):
    headers = {'Content-Type': 'application/xml'}
    result = requests.post(url, data=xml.encode("utf-8"), headers=headers)
    return result.text

def getRequest(url):
    result=requests.get(url)
    return result.text


