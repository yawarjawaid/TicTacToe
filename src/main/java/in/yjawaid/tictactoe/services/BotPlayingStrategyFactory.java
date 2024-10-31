package in.yjawaid.tictactoe.services;

import in.yjawaid.tictactoe.model.BotDifficultyLevel;
import in.yjawaid.tictactoe.services.strategies.botplayingstrategy.BotPlayingStrategy;
import in.yjawaid.tictactoe.services.strategies.botplayingstrategy.EasyBotPlayingStrategy;
import in.yjawaid.tictactoe.services.strategies.botplayingstrategy.HardBotPlayingStrategy;
import in.yjawaid.tictactoe.services.strategies.botplayingstrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        // Implement a factory method to return the bot playing strategy based on the bot difficulty level
        return switch(botDifficultyLevel) {
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        };
    }
}
