package simbot.example.listener;

import love.forte.catcode.CatCodeUtil;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbot.example.model.QQMachine.Friendinfo;

@Service
public class MyPlay {

    private final MessageContentBuilderFactory messageContentBuilderFactory;
    /**
     * 通过依赖注入获取一个 "消息正文构建器工厂"。
     *
     */
    @Autowired
    public MyPlay(MessageContentBuilderFactory messageContentBuilderFactory) {
        this.messageContentBuilderFactory = messageContentBuilderFactory;
    }

    @OnPrivate
    public void replyPrivateMsg1(PrivateMsg privateMsg, Sender sender){

        // 获取消息正文。
        MessageContent msgContent = privateMsg.getMsgContent();
        System.out.println(msgContent.getMsg());

        // 向 privateMsg 的账号发送消息，消息为当前接收到的消息。
        for (int i =0;i<10;i++){
            sender.sendPrivateMsg(privateMsg, msgContent);
        }


        // 再发送一个表情ID为'9'的表情。
        // 方法1：使用消息构建器构建消息并发送
        // 在绝大多数情况下，使用消息构建器所构建的消息正文 'MessageContent'
        // 是用来发送消息最高效的选择。
        // 相对的，MessageContentBuilder所提供的构建方法是十分有限的。

        // 获取消息构建器
        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();
        // 通过.text(...) 向builder中追加一句话。
        // 通过.face(ID) 向builder中追加一个表情。
        // 通过.build() 构建出最终消息。
        MessageContent msg = msgBuilder.text("emmm").face(9).build();

        // 直接通过这个msg发送。
        //sender.sendPrivateMsg(privateMsg, msg);

        // 方法2：使用CAT码发送消息。
        // 使用CAT码构建一个需要解析的消息是最灵活的，
        // 但是相对的，它的效率并不是十分的可观，毕竟在这其中可能会涉及到很多的'解析'操作。

        // 获取CAT码工具类实例
        CatCodeUtil catCodeUtil = CatCodeUtil.getInstance();

        // 构建一个类型为 'face', 参数为 'id=9' 的CAT码。
        // 有很多方法。

        // 1. 通过 codeBuilder 构建CAT码
        // String cat1 = catCodeUtil.getStringCodeBuilder("face", false).key("id").value(9).build();

        // 2. 通过CatCodeUtil.toCat 构建CAT码
        // String cat2 = catCodeUtil.toCat("face", "id=9");

        // 3. 通过模板构建CAT码
        String cat3 = catCodeUtil.getStringTemplate().face(8);

        // 在cat码前增加一句 '表情' 并发送
        sender.sendPrivateMsg(privateMsg, "表情：" + cat3);

    }
}
