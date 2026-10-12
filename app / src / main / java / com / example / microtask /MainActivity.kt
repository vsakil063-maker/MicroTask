package com.example.microtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MicroTaskAppScreen()
            }
        }
    }
}

@Composable
fun MicroTaskAppScreen() {
    val darkGradientBg = Brush.verticalGradient(
        colors = listOf(Color(0xFF070B19), Color(0xFF03050B))
    )

    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(darkGradientBg)
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { Spacer(modifier = Modifier.height(16.dp)) }

                // Top Header Section
                item { TopHeaderSection() }

                // Main Balance Card
                item { MainBalanceCard() }

                // Deposit & Withdraw Quick Actions
                item { DepositWithdrawRow() }

                // Quick Access Social Media Section
                item { QuickAccessSection() }

                // Task List Items
                item {
                    TaskRowCard(
                        icon = Icons.Default.Keyboard,
                        title = "Typing Task",
                        subtitle = "Type simple text & earn money",
                        rewardRange = "$0.10 – $0.50",
                        iconBgColor = Color(0xFF8E24AA)
                    )
                }

                item {
                    TaskRowCard(
                        icon = Icons.Default.Groups,
                        title = "Social Media",
                        subtitle = "Follow our social media",
                        rewardRange = "$0.20 – $1.00",
                        iconBgColor = Color(0xFF1E88E5)
                    )
                }

                // Special Bonus Banner
                item { SpecialOfferBanner() }

                item { Spacer(modifier = Modifier.height(24.dp)) }
            }
        }
    }
}

@Composable
fun TopHeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        Brush.linearGradient(listOf(Color(0xFF00C6FF), Color(0xFF0072FF)))
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("M", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text("MicroTask", color = Color(0xFFFFC107), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("Small Tasks Big Earnings", color = Color(0xFF90A4AE), fontSize = 11.sp)
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Notification Bell with Badge
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF131C38)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFF3D00))
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text("3", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // User Rank Badge
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFF1A233D)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFFFFD700), modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Silver", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
fun MainBalanceCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0D1B3E))
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("My Balance", color = Color(0xFF8FA2C7), fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text("$ 12.45", color = Color.White, fontSize = 34.sp, fontWeight = FontWeight.ExtraBold)
                    Text("≈ 1,240.00 BDT", color = Color(0xFF8FA2C7), fontSize = 12.sp)
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00E676)),
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text("Withdraw", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color(0xFF1B2A52), thickness = 1.dp)
            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Today Earn", color = Color(0xFF8FA2C7), fontSize = 11.sp)
                    Text("$ 2.35", color = Color(0xFF00E676), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Column {
                    Text("Total Earn", color = Color(0xFF8FA2C7), fontSize = 11.sp)
                    Text("$ 42.80", color = Color(0xFF29B6F6), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Column {
                    Text("Level", color = Color(0xFF8FA2C7), fontSize = 11.sp)
                    Text("Silver", color = Color(0xFFE040FB), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun DepositWithdrawRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .background(Brush.horizontalGradient(listOf(Color(0xFF00C853), Color(0xFF00897B))))
                .padding(16.dp)
        ) {
            Column {
                Text("Deposit", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("Add Money", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .background(Brush.horizontalGradient(listOf(Color(0xFF7C4DFF), Color(0xFF3F51B5))))
                .padding(16.dp)
        ) {
            Column {
                Text("Withdraw", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("Cash Out", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun QuickAccessSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Quick Access", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("Popular Earning Methods", color = Color(0xFF8FA2C7), fontSize = 11.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            QuickItemCard(modifier = Modifier.weight(1f), title = "YouTube", color = Color(0xFFFF0000))
            QuickItemCard(modifier = Modifier.weight(1f), title = "Facebook", color = Color(0xFF1877F2))
            QuickItemCard(modifier = Modifier.weight(1f), title = "Instagram", color = Color(0xFFE4405F))
            QuickItemCard(modifier = Modifier.weight(1f), title = "Video Ads", color = Color(0xFF9C27B0))
        }
    }
}

@Composable
fun QuickItemCard(modifier: Modifier = Modifier, title: String, color: Color) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF101935))
    ) {
        Column(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(title, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Medium)
            Text("+ Earn", color = Color(0xFF00E676), fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TaskRowCard(icon: ImageVector, title: String, subtitle: String, rewardRange: String, iconBgColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF101935))
    ) {
        Row(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(iconBgColor),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = Color.White)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(title, color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(subtitle, color = Color(0xFF8FA2C7), fontSize = 11.sp)
                }
            }

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFF23163A)
            ) {
                Text(
                    text = rewardRange,
                    color = Color(0xFFE040FB),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Composable
fun SpecialOfferBanner() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Brush.horizontalGradient(listOf(Color(0xFF8E24AA), Color(0xFFD81B60))))
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color.Red
                ) {
                    Text(
                        "SPECIAL OFFER",
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        color = Color.White,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("GET EXTRA BONUS", color = Color(0xFFFFEB3B), fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                Text("Complete Tasks & Win Big!", color = Color.White, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFF090E21)
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Assignment, contentDescription = null) },
            label = { Text("Task") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Headset, contentDescription = null) },
            label = { Text("Support") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.History, contentDescription = null) },
            label = { Text("History") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.GroupAdd, contentDescription = null) },
            label = { Text("Refer") }
        )
    }
}
