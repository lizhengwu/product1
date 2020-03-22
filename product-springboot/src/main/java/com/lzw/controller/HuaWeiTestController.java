package com.lzw.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class HuaWeiTestController {


	@PostMapping("/huaweiTest")
	public JSONObject huaweiTest(@RequestBody String jsonObject) {
		System.out.println(jsonObject);

		String s = new String("{\n" + "    \"errorCode\": \"0\",\n" + "    \"errorMessage\": \"\",\n" + "    \"version\": \"1.0\",\n" + "    \"reply\": {\n" + "        \"isEndSession\": false,\n" + "        \"displayText\": \"电影院，想去第几个？\",\n" + "        \"speech\": {\n" + "            \"text\": \"在您附近5.0公里有16个播放宠爱的影院。想去哪个？\",\n" + "            \"type\": \"Text\",\n" + "            \"ssml\": null\n" + "        },\n" + "        \"commands\": [\n" + "            {\n" + "                \"body\": {\n" + "                    \"templateContent\": {\n" + "                        \"items\": [\n" + "                            {\n" + "                                \"type\": \"basic-template\",\n" + "                                \"contentItems\": [\n" + "                                    {\n" + "                                        \"id\": \"1\",\n" + "                                        \"title\": \"宠爱\",\n" + "                                        \"score\": null,\n" + "                                        \"content\": [\n" + "                                            {\n" + "                                                \"subtitle\": \"今天10点25分以后\",\n" + "                                                \"combBody\": null\n" + "                                            }\n" + "                                        ],\n" + "                                        \"tag\": null,\n" + "                                        \"image\": null,\n" + "                                        \"link\": null,\n" + "                                        \"similarity\": null,\n" + "                                        \"operateType\": null,\n" + "                                        \"voiceCommand\": null\n" + "                                    }\n" + "                                ],\n" + "                                \"indexFlag\": null\n" + "                            },\n" + "                            {\n" + "                                \"type\": \"list-template\",\n" + "                                \"contentItems\": [\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"0\",\n" + "                                                \"title\": \"CGV星星影城（颐堤港店）\",\n" + "                                                \"subtitle\": \"朝阳区酒仙桥路18号颐堤港四层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥57\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"625米\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"11:20 • 13:25 • 15:30\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第1个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"1\",\n" + "                                                \"title\": \"枫花园汽车影院（朝阳公园店）\",\n" + "                                                \"subtitle\": \"朝阳区亮马桥路21号朝阳公园北门对面\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥153\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"2.3公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"17:25 • 21:20 • 22:35\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第2个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"2\",\n" + "                                                \"title\": \"中影CFR国际影城（望京商业中心店）\",\n" + "                                                \"subtitle\": \"朝阳区望京街9号望京商业中心F座负一层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥36.9\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"2.5公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"11:10 • 12:10 • 13:10\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第3个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"3\",\n" + "                                                \"title\": \"奥兰环球影城（方恒购物中心一店）\",\n" + "                                                \"subtitle\": \"朝阳区阜通东大街6号院4号楼四层4-010\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥38.9\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"2.6公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"11:10 • 12:20 • 13:05\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第4个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"4\",\n" + "                                                \"title\": \"奥兰环球影城（方恒购物中心二店）\",\n" + "                                                \"subtitle\": \"朝阳区阜通东大街6号院4号楼四层4-02至4-15\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥38\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"2.6公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"11:15 • 12:10 • 13:35\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第5个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"5\",\n" + "                                                \"title\": \"珠影耳东传奇影城（原传奇时代影城）\",\n" + "                                                \"subtitle\": \"朝阳区朝阳公园6号蓝色港湾国际商区A025\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥43.5\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"3.3公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"12:00 • 16:00 • 19:10\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第6个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"6\",\n" + "                                                \"title\": \"大地影院（望京新天地店）\",\n" + "                                                \"subtitle\": \"朝阳区望京合生麒麟社影院\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥39\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"3.6公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"11:10 • 11:55 • 14:00\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第7个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"7\",\n" + "                                                \"title\": \"完美世界影城比如店（原17.5影城）\",\n" + "                                                \"subtitle\": \"朝阳区京顺路111号1幢101内F1-44\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥39\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"3.8公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"18:10 • 22:20\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第8个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"8\",\n" + "                                                \"title\": \"中国电影博物馆\",\n" + "                                                \"subtitle\": \"朝阳区南影路9号\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥38\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"3.8公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第9个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"9\",\n" + "                                                \"title\": \"星典影城（亮马桥四季店）\",\n" + "                                                \"subtitle\": \"朝阳区亮马桥路48号四季商业中心3层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥39.9\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"4.0公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"10:50 • 12:10 • 13:20\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第10个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"10\",\n" + "                                                \"title\": \"橙天嘉禾影城（凤凰汇店）\",\n" + "                                                \"subtitle\": \"朝阳区三元桥曙光西里甲5号院凤凰汇购物中心3层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥50\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"4.4公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"10:40 • 13:10 • 15:15\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第11个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"11\",\n" + "                                                \"title\": \"魔影国际影城（达美免费停车店）\",\n" + "                                                \"subtitle\": \"朝阳区青年路7号院100幢-1层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥39.5\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"4.4公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"12:00 • 14:00 • 14:30\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第12个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"12\",\n" + "                                                \"title\": \"嘉华国际影城（姚家园路活力东方店）\",\n" + "                                                \"subtitle\": \"朝阳区姚家园路甲1号活力东方奥特莱斯购物中心四层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥39\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"4.5公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"12:20 • 16:30 • 20:40\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第13个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"13\",\n" + "                                                \"title\": \"北京华谊兄弟电影汇\",\n" + "                                                \"subtitle\": \"朝阳区新源南路甲2号华谊兄弟办公楼首层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥298\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"4.9公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"12:20 • 16:35 • 20:30\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第14个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"14\",\n" + "                                                \"title\": \"明星时代影城北京梦秀店\",\n" + "                                                \"subtitle\": \"朝阳区望京西路41号梦秀欢乐广场6F 明星时代影城\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥40\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"5.1公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"13:05 • 15:00 • 17:10\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第15个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    },\n" + "                                    {\n" + "                                        \"type\": \"transaction-template\",\n" + "                                        \"contentItems\": [\n" + "                                            {\n" + "                                                \"id\": \"15\",\n" + "                                                \"title\": \"保利国际影城-北京东坝店\",\n" + "                                                \"subtitle\": \"朝阳区东坝中路38号金隅嘉品MALL5层\",\n" + "                                                \"price\": {\n" + "                                                    \"price\": \"￥44\",\n" + "                                                    \"priceUnix\": \"起\",\n" + "                                                    \"description\": \"6.2公里\"\n" + "                                                },\n" + "                                                \"primaryText\": null,\n" + "                                                \"supportingText\": \"12:05 • 15:55 • 19:30\",\n" + "                                                \"subtext1\": null,\n" + "                                                \"subtext2\": null,\n" + "                                                \"link\": null,\n" + "                                                \"similarity\": null,\n" + "                                                \"operateType\": \"voice\",\n" + "                                                \"voiceCommand\": \"第16个\"\n" + "                                            }\n" + "                                        ],\n" + "                                        \"indexFlag\": null\n" + "                                    }\n" + "                                ],\n" + "                                \"indexFlag\": \"true\"\n" + "                            }\n" + "                        ],\n" + "                        \"buttonLinkArray\": null\n" + "                    },\n" + "                    \"templateType\": \"compound-template\"\n" + "                },\n" + "                \"head\": {\n" + "                    \"name\": \"DisplayTemplate\",\n" + "                    \"namespace\": \"Render\"\n" + "                }\n" + "            }\n" + "        ]\n" + "    }\n" + "}");

		return JSONObject.parseObject(s);
	}
}